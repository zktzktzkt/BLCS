package blcs.lwb.utils.fragment.WeChat;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import blcs.lwb.lwbtool.base.BasePresenter;

import blcs.lwb.lwbtool.utils.LogUtils;
import blcs.lwb.lwbtool.utils.RecyclerUtil;
import blcs.lwb.lwbtool.utils.RxToast;
import blcs.lwb.utils.Constants;
import blcs.lwb.utils.R;
import blcs.lwb.utils.adapter.WeChatAdapter;
import blcs.lwb.utils.fragment.BaseFragment;
import blcs.lwb.utils.manager.FramentManages;
import blcs.lwb.utils.utils.MyUtils;
import butterknife.BindView;

/**
 * TODO 仿微信功能及控件
 */

public class WeChatFunctionFragment extends BaseFragment {
    @BindView(R.id.tool_recyclerView)
    RecyclerView mRecycyler;
    @Override
    public void popBackListener(int returnCode, Bundle bundle) {
        activity.tlToolbar.setTitle(R.string.WeChatFunction);
    }

    @Override
    public void setMiddleTitle(Toolbar title) {
    }

    @Override
    protected void initView() {
        WeChatAdapter mAdapter = new WeChatAdapter();
        RecyclerUtil.init(activity,OrientationHelper.VERTICAL,mAdapter,mRecycyler);
        mAdapter.setNewData(MyUtils.getArray(activity, R.array.WeChat_Function));

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String item = (String) adapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.Item_Name,item);
                LogUtils.e(item);
                switch (item){
                    case FramentManages.FontSize:
                        addFrament(FramentManages.FontSize,bundle);
                        break;
                        default:
                            RxToast.info(activity,getString(R.string.function_unopen));
                            break;
                }
            }
        });
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.tool_recyclerview;
    }

}
