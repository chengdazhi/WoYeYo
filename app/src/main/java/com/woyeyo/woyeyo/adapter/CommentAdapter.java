package com.woyeyo.woyeyo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Comment;
import com.woyeyo.woyeyo.bean.Trade;
import com.woyeyo.woyeyo.utils.Clog;
import com.woyeyo.woyeyo.utils.ImageUtil;
import com.woyeyo.woyeyo.utils.ToastUtil;

/**
 * Created by fam_000 on 2016/3/23.
 */
public class CommentAdapter extends KBaseAdapter<Comment> {
    public CommentAdapter(Context context){
        super(context);
    }
    @Override
    public View getView(int positon,View convertView,ViewGroup parent){
        View view=null;
        final ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.comment_item,null);
            viewHolder=new ViewHolder();
            viewHolder.nickname=(TextView)view.findViewById(R.id.nickname);
            viewHolder.commentContent=(TextView)view.findViewById(R.id.commentContent);
            viewHolder.ratingBar=(RatingBar)view.findViewById(R.id.ratingBar);
            viewHolder.reply=(Button)view.findViewById(R.id.reply);
            viewHolder.replyContent=(EditText)view.findViewById(R.id.replyContent);
            viewHolder.userImage=(ImageView)view.findViewById(R.id.userImage);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        final Comment comment=itemList.get(positon);
        viewHolder.nickname.setText(comment.getPersonNickname());
        viewHolder.commentContent.setText(comment.getReview());
        viewHolder.ratingBar.setRating(comment.getStarNum());
        String userImgUrl=comment.getPersonImgUrl();
        ImageUtil.displayMyImage(userImgUrl, viewHolder.userImage);
        viewHolder.reply.setOnClickListener(new View.OnClickListener() {
            int flag = 0;//标记点击次数
            // TODO: 2016/3/23 需要优化
            @Override
            public void onClick(View v) {
                if(flag == 0){
                    viewHolder.replyContent.setVisibility(View.VISIBLE);
                }else if(flag == 1){
                    viewHolder.replyContent.setVisibility(View.INVISIBLE);
                }
                flag = (flag+1) % 2;
            }
        });
        return view;
    }
    private class ViewHolder{
        RatingBar ratingBar;
        TextView commentContent;
        TextView nickname;
        ImageView userImage;
        Button reply;
        EditText replyContent;


    }

}
