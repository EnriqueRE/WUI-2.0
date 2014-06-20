// Generated code from Butter Knife. Do not modify!
package com.cita.wallet.app;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.cita.wallet.app.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296266, "field 'welcome_message'");
    target.welcome_message = (android.widget.TextView) view;
  }

  public static void reset(com.cita.wallet.app.MainActivity target) {
    target.welcome_message = null;
  }
}
