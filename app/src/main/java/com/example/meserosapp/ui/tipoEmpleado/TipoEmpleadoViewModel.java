package com.example.meserosapp.ui.tipoEmpleado;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;
import com.example.meserosapp.data.modelo.BaseResponse;
import com.example.meserosapp.data.modelo.TipoEmpleado;
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

public class TipoEmpleadoViewModel extends ViewModel
{
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<List<TipoEmpleado>> _roles;
    private LiveData<List<TipoEmpleado>> roles;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public TipoEmpleadoViewModel() {
        _roles = new MutableLiveData<>();
        roles = _roles;
        _error = new MutableLiveData<>();
        error = _error;


    }

    LiveData<List<TipoEmpleado>> getRoles() {
        return roles;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }


    public void obtenerRoles() {
        compositeDisposable.add(
                wikiApiService.obtenerRoles(preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<TipoEmpleado>>() {

                            @Override
                            public void onSuccess(List<TipoEmpleado> roles) {
                                _roles.setValue(roles);
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
