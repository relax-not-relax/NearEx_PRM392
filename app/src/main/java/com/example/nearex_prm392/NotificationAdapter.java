package com.example.nearex_prm392;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class NotificationAdapter extends FragmentStatePagerAdapter {

    public NotificationAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ConfirmedOrder();
            case 1:
                return new PaidOrder();
            default:
                return new ConfirmedOrder();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Đã xác nhận";
                break;
            case 1:
                title = "Đã thanh toán";
                break;
        }
        return title;
    }
}
