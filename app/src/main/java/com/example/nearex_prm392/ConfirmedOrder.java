package com.example.nearex_prm392;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfirmedOrder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmedOrder extends Fragment implements NotiItemAdapter.OnButtonClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConfirmedOrder() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfirmedOrder.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfirmedOrder newInstance(String param1, String param2) {
        ConfirmedOrder fragment = new ConfirmedOrder();
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

    private RecyclerView rcvNotiItem;
    private NotiItemAdapter adapter;
    private ArrayList<NotificationItem> notificationItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_confirmed_order, container, false);

        rcvNotiItem = rootView.findViewById(R.id.rcvNotiItem);
        getData();

        return  rootView;
    }

    private void getData() {
        notificationItems = new ArrayList<>();

        notificationItems.add(new NotificationItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK", "134 Lê Văn Việt", "1", "330000"));
        notificationItems.add(new NotificationItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK", "134 Lê Văn Việt", "1", "330000"));
        notificationItems.add(new NotificationItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK", "134 Lê Văn Việt", "1", "330000"));
        notificationItems.add(new NotificationItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK", "134 Lê Văn Việt", "1", "330000"));
        notificationItems.add(new NotificationItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK", "134 Lê Văn Việt", "1", "330000"));
        notificationItems.add(new NotificationItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK", "134 Lê Văn Việt", "1", "330000"));
        notificationItems.add(new NotificationItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK", "134 Lê Văn Việt", "1", "330000"));

        adapter = new NotiItemAdapter(notificationItems);
        adapter.setOnButtonClickListener((NotiItemAdapter.OnButtonClickListener) this);
        rcvNotiItem.setAdapter(adapter);
        rcvNotiItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onButtonClick(int position) {
        startActivity(new Intent(getActivity(), ProductDetail.class));
    }
}