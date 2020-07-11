package com.example.meserosapp.ui.tipoDocumento;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;
import com.example.meserosapp.data.modelo.BaseResponse;
import com.example.meserosapp.data.modelo.TipoDocumento;
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

public class TipoDocumentoViewModel extends ViewModel
{
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<List<TipoDocumento>> _documentos;
    private LiveData<List<TipoDocumento>> documentos;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public TipoDocumentoViewModel() {
        _documentos = new MutableLiveData<>();
        documentos = _documentos;
        _error = new MutableLiveData<>();
        error = _error;


    }

    LiveData<List<TipoDocumento>> getDocumentos() {
        return documentos;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }

    public void obtenerDocumentos() {
        compositeDisposable.add(
                wikiApiService.obtenerDocumentos(preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<TipoDocumento>>() {

                            @Override
                            public void onSuccess(List<TipoDocumento> documentos) {
                                _documentos.setValue(documentos);
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
