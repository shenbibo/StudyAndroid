package com.study.sky.study.base.recycleview.viewholder;
import android.view.View;
import android.widget.TextView;

import com.study.sky.study.R;
import com.study.sky.study.base.recycleview.AbsView;
import com.study.sky.study.base.recycleview.BaseBean;
import com.study.sky.study.base.recycleview.beans.NormalBean;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/23.
 */
public class NormalView extends AbsView {

    private TextView title;

    private TextView content;

    public NormalView(View itemContentView){
        super(itemContentView);
    }


    @Override
    protected void bindChildrenViews() {
        title = (TextView) itemView.findViewById(R.id.title);
        content = (TextView) itemView.findViewById(R.id.content);
    }

    @Override
    public boolean setData(BaseBean bean) {
        super.setData(bean);
        NormalBean normalBean = (NormalBean) bean;
        title.setText(normalBean.title);
        content.setText(normalBean.content);
        return true;
    }
}
