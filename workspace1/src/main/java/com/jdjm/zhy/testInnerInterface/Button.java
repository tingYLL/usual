package com.jdjm.zhy.testInnerInterface;

public class Button {

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void click() {
        if (onClickListener != null) {
            onClickListener.onClick();
        }
    }

    public interface OnClickListener {
        void onClick();
    }


    public static void main(String[] args) {
        Button button = new Button();
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick() {
                System.out.println("我点哈哈哈");
            }
        });
        button.click();
    }
}
