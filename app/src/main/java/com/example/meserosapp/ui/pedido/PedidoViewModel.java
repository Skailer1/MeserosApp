package com.example.meserosapp.ui.pedido;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;
import com.example.meserosapp.data.modelo.AuthToken;
import com.example.meserosapp.data.modelo.BaseResponse;
import com.example.meserosapp.data.modelo.DetallePedido;
import com.example.meserosapp.data.modelo.Empleado;
import com.example.meserosapp.data.modelo.EstadoPedido;
import com.example.meserosapp.data.modelo.Mesa;
import com.example.meserosapp.data.modelo.Pedido;
import com.example.meserosapp.data.modelo.Usuario;
import com.example.meserosapp.data.preferences.SharedPreferencesManager;
import com.example.meserosapp.util.ApiUtil;
import com.example.meserosapp.util.RetrofitErrorUtil;

import java.util.List;

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
    private MutableLiveData<Pedido> _pedido;
    private LiveData<Pedido> pedido;
    private MutableLiveData<EstadoPedido> _estado;
    private LiveData<EstadoPedido> estado;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public PedidoViewModel() {
        _pedido = new MutableLiveData<>();
        pedido = _pedido;
        _estado = new MutableLiveData<>();
        estado = _estado;
        _error = new MutableLiveData<>();
        error = _error;
    }

    LiveData<Pedido> getPedido() {
        return pedido;
    }

    LiveData<EstadoPedido> getEstado() {
        return estado;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }



    public void crearPedido(Mesa mesaId, Usuario usuarioId ) {
        Pedido pedido = new Pedido(mesaId, usuarioId);
        compositeDisposable.add(
                wikiApiService.crearPedido(pedido, preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Pedido>() {

                            @Override
                            public void onSuccess(Pedido pedido1) {
                                if (pedido != null) {

                                    _pedido.setValue(pedido1);
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

    public void actualizarEstado(String descripcionEstado) {
        EstadoPedido estado = new EstadoPedido( descripcionEstado);
        compositeDisposable.add(
                wikiApiService.actualizarEstado(estado.getId(),estado, preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<EstadoPedido>() {

                            @Override
                            public void onSuccess(EstadoPedido estado1) {
                                if (estado != null) {

                                    _estado.setValue(estado1);


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
