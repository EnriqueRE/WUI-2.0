// Generated code from Butter Knife. Do not modify!
package com.cita.wallet.app.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AccountStatementFragment$$ViewInjector {
  public static void inject(Finder finder, final com.cita.wallet.app.fragments.AccountStatementFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 16908292, "field 'txtEmpty'");
    target.txtEmpty = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 16908298, "field 'statements_list'");
    target.statements_list = (android.widget.AbsListView) view;
  }

  public static void reset(com.cita.wallet.app.fragments.AccountStatementFragment target) {
    target.txtEmpty = null;
    target.statements_list = null;
  }
}
