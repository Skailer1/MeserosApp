package com.example.meserosapp.ui.producto;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;
import com.example.meserosapp.data.modelo.BaseResponse;
import com.example.meserosapp.data.modelo.Pedido;
import com.example.meserosapp.data.modelo.Producto;
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

public class ProductoViewModel extends ViewModel
{
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<List<Producto>> _productos;
    private LiveData<List<Producto>> productos;
    private MutableLiveData<List<Producto>> _productosTipo;
    private LiveData<List<Producto>> productosTipo;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public ProductoViewModel() {
        _productos = new MutableLiveData<>();
        productos = _productos;
        _productosTipo = new MutableLiveData<>();
        productosTipo = _productosTipo;
        _error = new MutableLiveData<>();
        error = _error;


    }

    LiveData<List<Producto>> getProductos() {
        return productos;
    }

    LiveData<List<Producto>> getProductosTipo() {
        return productosTipo;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }


    public void obtenerProductos() {
        compositeDisposable.add(
                wikiApiService.obtenerProductos(preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<Producto>>() {

                            @Override
                            public void onSuccess(List<Producto> productos) {
                                _productos.setValue(productos);
                            }

                            @Override
                            public void onError(Throwable e) {
                                BaseResponse baseResponse = RetrofitErrorUtil.obtenerRetrofitError(e);
                                _error.setValue(baseResponse);
                            }
                        })
        );
    }


    public void obtenerProductosPorTipo() {
        Producto producto = new Producto();
        compositeDisposable.add(
                wikiApiService.obtenerProductosPorTipo(producto.getTipoProducto().getId(),preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<Producto>>() {

                            @Override
                            public void onSuccess(List<Producto> productos) {
                                _productos.setValue(productos);
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
