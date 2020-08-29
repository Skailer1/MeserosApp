package com.example.meserosapp.ui.producto;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;
import com.example.meserosapp.data.modelo.BaseResponse;
import com.example.meserosapp.data.modelo.Mesa;
import com.example.meserosapp.data.modelo.TipoProducto;
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

public class TipoProductoViewModel extends ViewModel
{
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<List<TipoProducto>> _categorias;
    private LiveData<List<TipoProducto>> categorias;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public TipoProductoViewModel() {
        _categorias = new MutableLiveData<>();
        categorias = _categorias;
        _error = new MutableLiveData<>();
        error = _error;

    }

    LiveData<List<TipoProducto>> getCategorias() {
        return categorias;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }

    public void obtenerCategorias() {
        compositeDisposable.add(
                wikiApiService.obtenerCategorias(preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<TipoProducto>>() {

                            @Override
                            public void onSuccess(List<TipoProducto> categorias) {
                                _categorias.setValue(categorias);
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