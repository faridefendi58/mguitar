package net.kuncilagu.kuncigitar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.kuncilagu.kuncigitar.R;
import net.kuncilagu.kuncigitar.adapter.AdapterListNewReleases;
import net.kuncilagu.kuncigitar.adapter.AdapterListRecommended;
import net.kuncilagu.kuncigitar.data.DataGenerator;
import net.kuncilagu.kuncigitar.model.NewReleaseModel;
import net.kuncilagu.kuncigitar.model.RecommendedSongModel;

import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_tabs_home, container, false);


        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.newrelease_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);

        RecyclerView recommended_recycle = (RecyclerView) root.findViewById(R.id.recommended_recycle);
        recommended_recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        recommended_recycle.setHasFixedSize(true);

        List<NewReleaseModel> items = DataGenerator.getNewReleaseModel(getActivity());
        Collections.shuffle(items);

        //set data and list adapter
        AdapterListNewReleases mAdapter = new AdapterListNewReleases(getActivity(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListNewReleases.OnItemClickListener() {
            @Override
            public void onItemClick(View view, NewReleaseModel obj, int position) {
                Toast.makeText(getActivity(), "Item " + obj.title + " clicked", Toast.LENGTH_SHORT).show();
            }
        });

        mAdapter.setOnMoreButtonClickListener(new AdapterListNewReleases.OnMoreButtonClickListener() {
            @Override
            public void onItemClick(View view, NewReleaseModel obj, MenuItem item) {
                Toast.makeText(getActivity(), obj.title + " (" + item.getTitle() + ") clicked", Toast.LENGTH_SHORT).show();
            }
        });

        List<RecommendedSongModel> items_recommended = DataGenerator.getRecommendedSongModel(getActivity());
        Collections.shuffle(items);

        AdapterListRecommended rAdapter = new AdapterListRecommended(getActivity(), items_recommended);
        recommended_recycle.setAdapter(rAdapter);

        return root;
    }
}