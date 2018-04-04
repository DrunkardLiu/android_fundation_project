package liu.drunkard.foundationproject.utility;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by laurenceliu on 2018/4/3.
 * Every LayoutManager for RecyclerView
 */

public class SetUpLayoutManager {
    public static void verticalLinearLayout(Context context, RecyclerView targetRecyclerView) {
        LinearLayoutManager placeLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        targetRecyclerView.setHasFixedSize(true);
        targetRecyclerView.setLayoutManager(placeLayoutManager);
    }

    public static void horizontalLinearLayout(Context context, RecyclerView targetRecyclerView) {
        LinearLayoutManager placeLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        targetRecyclerView.setHasFixedSize(true);
        targetRecyclerView.setLayoutManager(placeLayoutManager);
    }

    public static void gridLayout(Context context, RecyclerView targetRecyclerView, int numberOfColumn) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, numberOfColumn);
        targetRecyclerView.setHasFixedSize(true);
        targetRecyclerView.setLayoutManager(gridLayoutManager);
    }

    public static void staggeredGridLayout(RecyclerView targetRecyclerView) {
        StaggeredGridLayoutManager spotLayoutManager = new StaggeredGridLayoutManager(3, 1);
        spotLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        targetRecyclerView.setHasFixedSize(true);
        targetRecyclerView.setLayoutManager(spotLayoutManager);
    }
}

