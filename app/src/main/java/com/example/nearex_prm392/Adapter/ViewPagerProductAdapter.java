package com.example.nearex_prm392.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.nearex_prm392.Fragment.BiscuitFragment;
import com.example.nearex_prm392.Fragment.DrinkFragment;
import com.example.nearex_prm392.Fragment.FoodFragment;
import com.example.nearex_prm392.Fragment.FruitFragment;
import com.example.nearex_prm392.Fragment.MeatFragment;
import com.example.nearex_prm392.Fragment.MilkFragment;
import com.example.nearex_prm392.Fragment.NoodlesFragment;
import com.example.nearex_prm392.Fragment.PackageFragment;
import com.example.nearex_prm392.Fragment.SeafoodFragment;
import com.example.nearex_prm392.Fragment.VegeFragment;

public class ViewPagerProductAdapter extends FragmentStatePagerAdapter {



    public ViewPagerProductAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MeatFragment();
            case 1:
                return new SeafoodFragment();
            case 2:
                return new VegeFragment();
            case 3:
                return new FruitFragment();
            case 4:
                return new MilkFragment();
            case 5:
                return new BiscuitFragment();
            case 6:
                return new DrinkFragment();
            case 7:
                return new NoodlesFragment();
            case 8:
                return new PackageFragment();
            case 9:
                return new FoodFragment();
            default:
                return new MeatFragment();

        }

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Thịt";
                break;
            case 1:
                title = "Hải sản";
                break;
            case 2:
                title = "Rau củ";
                break;
            case 3:
                title = "Trái cây";
                break;
            case 4:
                title = "Sữa";
                break;
            case 5:
                title = "Bánh kẹo";
                break;
            case 6:
                title = "Đồ uống";
                break;
            case 7:
                title = "Mì";
                break;
            case 8:
                title = "Thực phẩm khô";
                break;
            case 9:
                title = "Thực phẩm chế biến";
                break;
        }
        return title;
    }
}
