// Generated code from Butter Knife. Do not modify!
package com.cita.wallet.app.adapters;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class StatementAdapter$ViewHolder$$ViewInjector {
  public static void inject(Finder finder, final com.cita.wallet.app.adapters.StatementAdapter.ViewHolder target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296278, "field 'tuition'");
    target.tuition = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296280, "field 'insurance'");
    target.insurance = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296286, "field 'interests'");
    target.interests = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296283, "field 'date'");
    target.date = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296276, "field 'background'");
    target.background = (android.widget.GridLayout) view;
    view = finder.findRequiredView(source, 2131296281, "field 'services'");
    target.services = (android.widget.TextView) view;
  }

  public static void reset(com.cita.wallet.app.adapters.StatementAdapter.ViewHolder target) {
    target.tuition = null;
    target.insurance = null;
    target.interests = null;
    target.date = null;
    target.background = null;
    target.services = null;
  }
}
