package com.xiong.tuan.ui.login;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.EditText;

import com.xiong.tuan.MVP.base.MvpBaseFragment;
import com.xiong.tuan.MVP.base.BaseActivity;
import com.xiong.tuan.R;
import com.xiong.tuan.entity.User;
import com.xiong.tuan.present.LoginPresenter;
import com.xiong.tuan.view.LoginView;

import butterknife.InjectView;

/**
 * Created by hui.xiong on 2016/3/14.
 */
public class LoginActivity extends BaseActivity{
    private static final String TAG ="login";

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_frag_container);
        toFragment(R.id.fragment_container,new LoginFrag(),TAG);
    }

    public static class LoginFrag extends MvpBaseFragment<LoginView,LoginPresenter> implements LoginView{
        @Override
        protected int getLayoutRes() {
            return R.layout.login;
        }

        @InjectView(R.id.edtPhoneNum)
        EditText edtPhoneNum;
        @InjectView(R.id.edtPasswd)
        EditText edtPasswd;

        @Override
        public void showLoginDialog() {

        }

        @Override
        public void dismissLoginDialog() {

        }

        @Override
        public void showLoginResultMsg(String msg) {

        }

        @Override
        public void loginSucc(User user) {

        }

        @Override
        public void loginFail() {

        }

        @Override
        public void showUserHangUpDialog() {

        }

        @Override
        public LoginPresenter createPresenter() {
            return null;
        }
    }
}
