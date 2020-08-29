package com.example.meserosapp.ui.pago;


import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;
import com.example.meserosapp.data.modelo.BaseResponse;
import com.example.meserosapp.data.modelo.Pedido;
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

public class PagoViewModel extends ViewModel
{
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<List<Pedido>> _pedidos;
    private LiveData<List<Pedido>> pedidos;
  /*  private MutableLiveData<Pedido> _pedido;
    private LiveData<Pedido> pedido;
    private MutableLiveData<Pedido> _pedidoE;
    private LiveData<Pedido> pedidoE;*/
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public PagoViewModel() {
        _pedidos = new MutableLiveData<>();
        pedidos = _pedidos;
    /*    _pedido = new MutableLiveData<>();
        pedido = _pedido;
        _pedidoE = new MutableLiveData<>();
        pedidoE = _pedidoE;*/
        _error = new MutableLiveData<>();
        error = _error;


    }

    LiveData<List<Pedido>> getPedidos() {
        return pedidos;
    }

  /*  LiveData<Pedido> getPedido() {
        return pedido;
    }

    LiveData<Pedido> getPedidoE() {
        return pedidoE;
    }*/

    LiveData<BaseResponse> getError() {
        return error;
    }

    public void obtenerPedidos() {
        compositeDisposable.add(
                wikiApiService.obtenerPedidos(preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<Pedido>>() {

                            @Override
                            public void onSuccess(List<Pedido> pedidos) {
                                _pedidos.setValue(pedidos);
                            }

                            @Override
                            public void onError(Throwable e) {
                                BaseResponse baseResponse = RetrofitErrorUtil.obtenerRetrofitError(e);
                                _error.setValue(baseResponse);
                            }
                        })
        );
    }


  /*  public void obtenerPedido() {
        Pedido pedido = new Pedido();
        compositeDisposable.add(
                wikiApiService.obtenerPedido(pedido.getId() ,preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Pedido>() {

                            @Override
                            public void onSuccess(Pedido pedido) {
                                _pedido.setValue(pedido);

                            }



                            @Override
                            public void onError(Throwable e) {
                                BaseResponse baseResponse = RetrofitErrorUtil.obtenerRetrofitError(e);
                                _error.setValue(baseResponse);
                            }
                        })
        );
    }

    public void eliminarPedido() {
        Pedido pedido = new Pedido();
        compositeDisposable.add(
                wikiApiService.obtenerPedido(pedido.getId() ,preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Pedido>() {

                            @Override
                            public void onSuccess(Pedido pedido) {
                                _pedido.setValue(pedido);

                            }

                            @Override
                            public void onError(Throwable e) {
                                BaseResponse baseResponse = RetrofitErrorUtil.obtenerRetrofitError(e);
                                _error.setValue(baseResponse);
                            }
                        })
        );
    }
*/

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }
}
