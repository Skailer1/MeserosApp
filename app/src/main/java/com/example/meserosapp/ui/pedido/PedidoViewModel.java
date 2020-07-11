package com.example.meserosapp.ui.pedido;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;
import com.example.meserosapp.data.modelo.AuthToken;
import com.example.meserosapp.data.modelo.BaseResponse;
import com.example.meserosapp.data.modelo.Empleado;
import com.example.meserosapp.data.modelo.EstadoPedido;
import com.example.meserosapp.data.modelo.Mesa;
import com.example.meserosapp.data.modelo.Pedido;
import com.example.meserosapp.data.preferences.SharedPreferencesManager;
import com.example.meserosapp.util.ApiUtil;
import com.example.meserosapp.util.RetrofitErrorUtil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class PedidoViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<AuthToken> _authToken;
    private LiveData<AuthToken> authToken;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public PedidoViewModel() {
        _authToken = new MutableLiveData<>();
        authToken = _authToken;
        _error = new MutableLiveData<>();
        error = _error;
    }

    LiveData<AuthToken> getAuthToken() {
        return authToken;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }

    public void pedido(Long id, String fechaPedido,boolean isActivo, String fechaActualizacion,
                       String fechaCreacion, Empleado empleadoId, Mesa mesaId, EstadoPedido estadoId  ) {
        Pedido pedido = new Pedido(id, fechaPedido, isActivo, fechaActualizacion, fechaCreacion, empleadoId, mesaId,estadoId);
        compositeDisposable.add(
                wikiApiService.pedido(pedido)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<AuthToken>() {

                            @Override
                            public void onSuccess(AuthToken authToken) {
                                if (authToken != null) {
                                    preferencesManager.setAuthToken("Bearer " + authToken.getAuthToken());
                                    _authToken.setValue(authToken);
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                BaseResponse baseResponse = RetrofitErrorUtil.obtenerRetrofitError(e);
                                _error.setValue(baseResponse);
                            }
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }
}
