package com.study.sky.study.base.recycleview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;

import com.study.sky.study.base.recycleview.model.BaseBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/4/18.
 * function:
 */
public class ViewCreateFactory {

    private static int typeNumber = 0;

    /**
     * 保存viewType - ViewHolder对应关系的Map
     */
    private final static SparseArray<Class<? extends AbsView>> TYPE_TO_ITEM_VIEW_MAP = new SparseArray<>();

    /**
     * 保存viewHolderName与viewType之间的关系
     */
    private final static HashMap<String, Integer> ITEM_VIEW_NAME_TO_TYPE_MAP = new HashMap<>();

    /**
     * 保存itemView与Bean之间的映射关系
     */
    private final static HashMap<Class<? extends AbsView>, Class<? extends BaseBean>> ITEM_VIEW_TO_BEAN_MAP = new HashMap<>();

    /**
     * 保存itemview与Node之间的映射
     */
    private static HashMap<Class<? extends AbsView>, Class<? extends AbsNode>> ITEM_VIEW_TO_NODE_MAP = new HashMap<>();

    /**
     * 分别存储view-type, bean-type, view-bean的映射
     */
    public static void registerItemView(String itemViewName, Class<? extends AbsView> clazz) {
        ++typeNumber;
        TYPE_TO_ITEM_VIEW_MAP.put(typeNumber, clazz);
        ITEM_VIEW_NAME_TO_TYPE_MAP.put(itemViewName, typeNumber);
    }

    /**
     * 注册ItemView与Node之间的映射关系
     */
    public static void registerNode(Class<? extends AbsView> clazz, Class<? extends AbsNode> clazz2) {
        ITEM_VIEW_TO_NODE_MAP.put(clazz, clazz2);
    }

    /**
     * 注册itemView与Bean之间的映射关系
     */
    public static void registerBean(Class<? extends AbsView> clazz, Class<? extends BaseBean> clazz2) {
        ITEM_VIEW_TO_BEAN_MAP.put(clazz, clazz2);
    }

    /**
     * 通过itemview.class对象获取bean的class对象
     */
    @SuppressWarnings("unchecked")
    public static Class<? extends BaseBean> getBeanClass(Class<? extends AbsView> clazz) {
        Class clazz1 = ITEM_VIEW_TO_BEAN_MAP.get(clazz);
        if (clazz1 == null) {
            throw new RuntimeException("the itemView is not registered , itemView = " + clazz.getSimpleName());
        }
        return clazz1;
    }

    public static int getType(String itemViewName) {
        return ITEM_VIEW_NAME_TO_TYPE_MAP.get(itemViewName);
    }

    /**
     * 通过类型创建对应的Node
     */
    @SuppressWarnings("all")
    public static AbsNode createNode(int type, Context context) {

        Class<? extends AbsNode> clazz = ITEM_VIEW_TO_NODE_MAP.get(TYPE_TO_ITEM_VIEW_MAP.get(type));
        AbsNode node = null;
        if (clazz != null) {

            try {
                Constructor<? extends AbsNode> constructor = clazz.getConstructor(Context.class);
                node = constructor.newInstance(context);
            } catch (NoSuchMethodException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return node;
    }

    /**
     * 通过类型创建对应的ViewHolder
     */
    @SuppressWarnings("all")
    public static AbsView createItemView(View itemView, int type) {

        Class<? extends AbsView> clazz = TYPE_TO_ITEM_VIEW_MAP.get(type);
        AbsView holder = null;
        if (clazz != null) {

            try {
                Constructor<? extends AbsView> constructor = clazz.getConstructor(View.class);
                holder = constructor.newInstance(itemView);
            } catch (NoSuchMethodException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return holder;
    }

}
