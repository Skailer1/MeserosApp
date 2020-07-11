package com.example.meserosapp.ui.mesa;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.data.api.WikiApiService;
import com.example.meserosapp.data.modelo.BaseResponse;
import com.example.meserosapp.data.modelo.Mesa;
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

public class MesaViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WikiApiService wikiApiService = ApiUtil.obtenerWikiApiService();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private MutableLiveData<List<Mesa>> _mesas;
    private LiveData<List<Mesa>> mesas;
    private MutableLiveData<BaseResponse> _error;
    private LiveData<BaseResponse> error;

    public MesaViewModel() {
        _mesas = new MutableLiveData<>();
        mesas = _mesas;
        _error = new MutableLiveData<>();
        error = _error;


    }

    LiveData<List<Mesa>> getMesas() {
        return mesas;
    }

    LiveData<BaseResponse> getError() {
        return error;
    }


    public void obtenerMesas() {
        compositeDisposable.add(
                wikiApiService.obtenerMesas(preferencesManager.getAuthToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<Mesa>>() {

                            @Override
                            public void onSuccess(List<Mesa> mesas) {
                                _mesas.setValue(mesas);
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
