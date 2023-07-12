package com.example.nearex_prm392.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nearex_prm392.Adapter.ShopAdapter;
import com.example.nearex_prm392.ProductDetail;
import com.example.nearex_prm392.R;
import com.example.nearex_prm392.ShopItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PackageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PackageFragment extends Fragment implements ShopAdapter.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PackageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PackageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PackageFragment newInstance(String param1, String param2) {
        PackageFragment fragment = new PackageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView rcvProduct;
    private ShopAdapter adapter;
    private ArrayList<ShopItem> shopItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_package, container, false);

        rcvProduct = rootView.findViewById(R.id.rcvProduct);
        getData();

        return rootView;
    }

    private void getData() {
        shopItems = new ArrayList<>();

        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));

        adapter = new ShopAdapter(shopItems);
        adapter.setOnItemClickListener((ShopAdapter.OnItemClickListener) this);
        rcvProduct.setAdapter(adapter);
        rcvProduct.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(getActivity(), ProductDetail.class));
    }
}