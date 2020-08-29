package com.example.meserosapp.ui.registro;


import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;

import com.example.meserosapp.data.modelo.BaseResponse;
import com.example.meserosapp.data.modelo.Empleado;
import com.example.meserosapp.data.modelo.Usuario;
import com.example.meserosapp.data.preferences.SharedPreferencesManager;
import com.example.meserosapp.data.singleton.Singleton;
import com.example.meserosapp.util.ApiUtil;
import com.example.meserosapp.util.RetrofitErrorUtil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RegistroViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private Singleton singleton = Singleton.obtenerInstancia();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<Empleado> _empleado;
    private LiveData<Empleado> empleado;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public RegistroViewModel() {
        _empleado = new MutableLiveData<>();
        empleado = _empleado;
        _error = new MutableLiveData<>();
        error = _error;
    }

    LiveData<Empleado> getEmpleado() {
        return empleado;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }


    public void crearEmpleado(  String nombre, Long telefono, String rh, String sexo,String tipoDocumento
                              , String tipoEmpleado, Long numeroDocumento, String direccion) {
        Empleado empleado = new Empleado( nombre, telefono, rh, sexo,
                tipoDocumento, tipoEmpleado, numeroDocumento ,direccion);
        compositeDisposable.add(
                wikiApiService.crearEmpleado( empleado,preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Empleado>() {

                            @Override
                            public void onSuccess(Empleado empleado1) {
                                if (empleado != null) {

                                   // singleton.getUsuarioId();
                                    _empleado.setValue(empleado1);


                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                BaseResponse baseResponse = RetrofitErrorUtil.obtenerRetrofitError(e);
                                _error.setValue(baseResponse);
                            }
                        })
        );
        singleton.getUsuarioId();
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


