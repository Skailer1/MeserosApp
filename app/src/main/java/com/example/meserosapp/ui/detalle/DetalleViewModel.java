package com.example.meserosapp.ui.detalle;

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

public class DetalleViewModel extends ViewModel
{
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<List<Pedido>> _pedido;
    private LiveData<List<Pedido>> pedido;
    private MutableLiveData<Pedido> _dPedido;
    private LiveData<Pedido> dPedido;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public DetalleViewModel() {
        _pedido = new MutableLiveData<>();
        pedido = _pedido;
        _dPedido = new MutableLiveData<>();
        dPedido = _dPedido;
        _error = new MutableLiveData<>();
        error = _error;


    }

    LiveData<List<Pedido>> getPedido() {
        return pedido;
    }

    LiveData<Pedido> getPedidoE() {
        return dPedido;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }


}
