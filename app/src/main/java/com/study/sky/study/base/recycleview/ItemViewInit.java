package com.study.sky.study.base.recycleview;

import com.study.sky.study.base.recycleview.beans.NormalBean;
import com.study.sky.study.base.recycleview.node.NormalNode;
import com.study.sky.study.base.recycleview.viewholder.NormalView;

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

    /**
     * 注册viewType-itemView之间的关系
     */
    static void registerViewType2ItemView() {
        ViewCreateFactory.registerItemView(NORMAL_VIEW, NormalView.class);
    }

    /**
     * 注册itemview-Node之间的关系
     */
    static void registerItemView2Node() {
        ViewCreateFactory.registerNode(NormalView.class, NormalNode.class);
    }

    /**
     * 注册itemView-bean之间的关系
     */
    static void registerItemView2Bean() {
        ViewCreateFactory.registerBean(NormalView.class, NormalBean.class);
    }

    public static void init() {
        registerViewType2ItemView();
        registerItemView2Node();
        registerItemView2Bean();
    }
}
