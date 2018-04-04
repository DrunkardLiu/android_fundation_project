package liu.drunkard.foundationproject.RecyclerViewSample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import liu.drunkard.foundationproject.R;
import liu.drunkard.foundationproject.model.GitHubUser;
import liu.drunkard.foundationproject.utility.OnItemClickListener;

/**
 * Created by laurenceliu on 2018/4/4.
 */

public class GitHubUserAdapter extends RecyclerView.Adapter<GitHubUserAdapter.GitHubViewHolder> {

    private Context mContext;
    private List<GitHubUser> mGitHubUserList;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public GitHubUserAdapter(Context context, List<GitHubUser> gitHubUserList) {
        this.mContext = context;
        this.mGitHubUserList = gitHubUserList;
    }

    @NonNull
    @Override
    public GitHubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_github_user, viewGroup, false);

        return new GitHubViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubViewHolder holder, final int position) {
        GitHubUser gitHubUser = getItem(position);

        holder.nameTextView.setText(gitHubUser.login);
        holder.typeTextView.setText(gitHubUser.type);
        Picasso.get().load(gitHubUser.avatarUrl).placeholder(R.mipmap.ic_launcher).into(holder.avatarImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGitHubUserList.size();
    }

    public GitHubUser getItem(int position) {
        return mGitHubUserList.get(position);
    }

    public static class GitHubViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView typeTextView;
        private ImageView avatarImageView;

        public GitHubViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            typeTextView = (TextView) itemView.findViewById(R.id.typeTextView);
            avatarImageView = (ImageView) itemView.findViewById(R.id.avatarImageView);
        }
    }

}
