package com.example.musicrecapp.ui.musiclist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class musiclistViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public musiclistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Music List fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}