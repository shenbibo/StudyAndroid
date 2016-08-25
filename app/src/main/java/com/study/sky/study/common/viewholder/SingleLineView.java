package com.study.sky.study.common.viewholder;

import android.view.View;
import android.widget.TextView;

import com.study.sky.study.R;
import com.study.sky.study.base.recycleview.AbsView;
import com.study.sky.study.base.recycleview.BaseBean;
import com.study.sky.study.common.beans.SingleLineBean;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/23.
 */
public class SingleLineView extends AbsView{

    private TextView name;

    public SingleLineView(View itemContentView) {
        super(itemContentView);
    }

    @Override
    protected void bindChildrenViews() {
        name = (TextView) itemView.findViewById(R.id.setting_item_title);
    }

    @Override
    public void setData(BaseBean bean) {
        super.setData(bean);
        SingleLineBean bean1 = (SingleLineBean) bean;
        name.setText(bean1.name);
    }
}
