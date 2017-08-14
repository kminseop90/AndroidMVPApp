package com.example.owner.mvpsampleapp.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.example.owner.mvpsampleapp.R;
import com.example.owner.mvpsampleapp.databinding.DialogCommonBinding;

public class CommonDialog extends Dialog {

    private final Context context;
    private final ButtonType btnType;
    private final String title;
    private final String message;
    private final String positive;
    private final String negative;
    private final DialogListener positiveClickListener;
    private final DialogListener negativeClickListener;
    public enum ButtonType {
        ONE_BTN, TWO_BTN,
    }

    private DialogCommonBinding binding; // onCreate 생성

    public CommonDialog(Builder builder) {
        super(builder.context);
        this.context = builder.context;
        this.btnType = builder.type;
        this.title = builder.title;
        this.message = builder.message;
        this.positive = builder.positive;
        this.negative = builder.negative;
        this.positiveClickListener = builder.positiveClickListener;
        this.negativeClickListener = builder.negativeClickListener;
        setView();
    }

    private void setView() {
        this.binding = DataBindingUtil.inflate(LayoutInflater.from(this.context), R.layout.dialog_common, null, false);
        this.binding.setDialog(this);
        setContentView(this.binding.getRoot());
    }

    public void onPositiveClick(View v) {
        if(this.positiveClickListener != null) {
            this.positiveClickListener.onClickListener(this);
        }
        this.dismiss();
    }

    public void onNegativeClick(View v) {
        if(this.negativeClickListener != null) {
            this.negativeClickListener.onClickListener(this);
        }
        this.dismiss();
    }

    @Override
    public void show() {
        if(isNullOrEmpty(title)) {
            this.binding.commonTitle.setText(title);
            this.binding.commonTitle.setVisibility(View.VISIBLE);
        } else {
            this.binding.commonTitle.setVisibility(View.GONE);
        }
        if(isNullOrEmpty(message)) {
            this.binding.commonMessage.setText(message);
            this.binding.commonMessage.setVisibility(View.VISIBLE);
        } else {
            this.binding.commonMessage.setVisibility(View.GONE);
        }
        this.binding.commonPositive.setText(positive);
        this.binding.commonNegative.setText(negative);
        switch (btnType) {
            case ONE_BTN:
                this.binding.commonPositive.setVisibility(View.VISIBLE);
                this.binding.commonNegative.setVisibility(View.GONE);
                break;
            case TWO_BTN:
                this.binding.commonPositive.setVisibility(View.VISIBLE);
                this.binding.commonNegative.setVisibility(View.VISIBLE);
                break;
            default:
                new Exception();
                break;
        }
        super.show();
    }

    private boolean isNullOrEmpty(String msg) {
        if (msg != null) {
            return !"".equals(msg);
        } else {
            return false;
        }
    }

    public static class Builder {

        private Context context;
        private ButtonType type;
        private String title;
        private String message;
        private String positive;
        private String negative;
        private DialogListener positiveClickListener;
        private DialogListener negativeClickListener;

        public Builder(Context context, ButtonType type) {
            this.context = context;
            this.type = type;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder positiveButton(String positive, DialogListener clickListener) {
            this.positive = positive;
            this.positiveClickListener = clickListener;
            return this;
        }

        public Builder negativeButton(String negative, DialogListener clickListener) {
            this.negative = negative;
            this.negativeClickListener = clickListener;
            return this;
        }

        public CommonDialog build() {
            return new CommonDialog(this);
        }

    }

    public interface DialogListener {
        void onClickListener(CommonDialog commonDialog);
    }
}