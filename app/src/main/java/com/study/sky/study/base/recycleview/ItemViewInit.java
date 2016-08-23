package com.study.sky.study.base.recycleview;

import com.study.sky.study.base.recycleview.beans.NormalBean;
import com.study.sky.study.base.recycleview.beans.SingleLineBean;
import com.study.sky.study.base.recycleview.node.NormalNode;
import com.study.sky.study.base.recycleview.node.SingleLineNode;
import com.study.sky.study.base.recycleview.viewholder.NormalView;
import com.study.sky.study.base.recycleview.viewholder.SingleLineView;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/19.
 */
public final class ItemViewInit {

    private ItemViewInit() {
    }

    /**
     * 定义ViewType的名称
     */
    public static final String NORMAL_VIEW = NormalView.class.getSimpleName();
    public static final String SINGLE_LINE_VIEW = SingleLineView.class.getSimpleName();

    /**
     * 注册viewType-itemView之间的关系
     */
    static void registerViewType2ItemView() {
        ViewCreateFactory.registerItemView(NORMAL_VIEW, NormalView.class);
        ViewCreateFactory.registerItemView(SINGLE_LINE_VIEW, SingleLineView.class);
    }

    /**
     * 注册itemview-Node之间的关系
     */
    static void registerItemView2Node() {
        ViewCreateFactory.registerNode(NormalView.class, NormalNode.class);
        ViewCreateFactory.registerNode(SingleLineView.class, SingleLineNode.class);

    }

    /**
     * 注册itemView-bean之间的关系
     */
    static void registerItemView2Bean() {
        ViewCreateFactory.registerBean(NormalView.class, NormalBean.class);
        ViewCreateFactory.registerBean(SingleLineView.class, SingleLineBean.class);
    }

    public static void init() {
        registerViewType2ItemView();
        registerItemView2Node();
        registerItemView2Bean();
    }
}
