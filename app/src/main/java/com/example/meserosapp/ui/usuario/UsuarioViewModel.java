package com.example.meserosapp.ui.usuario;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;
import com.example.meserosapp.data.modelo.BaseResponse;
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

public class UsuarioViewModel extends ViewModel
{
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private Singleton singleton = Singleton.obtenerInstancia();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<Usuario> _usuario;
    private LiveData<Usuario> usuario;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public UsuarioViewModel() {
        _usuario = new MutableLiveData<>();
        usuario = _usuario;
        _error = new MutableLiveData<>();
        error = _error;
    }

    LiveData<Usuario> getUsuario() {
        return usuario;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }


    public void crearUsuario( String nombreUsuario, String correo, String contrasenia ) {
        Usuario usuario = new Usuario( nombreUsuario, correo,contrasenia);
        compositeDisposable.add(
                wikiApiService.crearUsuario(usuario,preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Usuario>() {

                            @Override
                            public void onSuccess(Usuario usuario1) {
                                if (usuario != null) {

                                    _usuario.setValue(usuario1);

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
