package com.example.ocpizza.view_model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class RegistrationViewModelFactory implements ViewModelProvider.Factory {

    Context context;
    public RegistrationViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        context.getClass();
            if (modelClass.isAssignableFrom(RegistrationViewModel.class)) {
                return (T) new RegistrationViewModel(context);
            }
            throw new IllegalArgumentException("Unknown ViewModel class");
        }

}
