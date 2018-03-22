/* Copyright (C) 2014  olie.xdev <olie.xdev@googlemail.com>
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>
*/
package com.health.openscale.gui.views;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.health.openscale.R;
import com.health.openscale.core.datatypes.ScaleMeasurement;
import com.health.openscale.core.evaluation.EvaluationResult;
import com.health.openscale.core.evaluation.EvaluationSheet;

public class BMIMeasurementView extends FloatMeasurementView {
    public static final String KEY = "bmi";
    private static final String[] DEPENDENCY = {WeightMeasurementView.KEY};

    public BMIMeasurementView(Context context) {
        super(context, context.getResources().getString(R.string.label_bmi), ContextCompat.getDrawable(context, R.drawable.ic_bmi));
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String[] getDependencyKeys() {
        return DEPENDENCY;
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    @Override
    protected float getMeasurementValue(ScaleMeasurement measurement) {
        return measurement.getBMI(getScaleUser().getBodyHeight());
    }

    @Override
    protected void setMeasurementValue(float value, ScaleMeasurement measurement) {
        // Empty
    }

    @Override
    public String getUnit() {
        return "";
    }

    @Override
    protected float getMaxValue() {
        return 50;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#EC407A");
    }

    @Override
    protected EvaluationResult evaluateSheet(EvaluationSheet evalSheet, float value) {
        return evalSheet.evaluateBMI(value);
    }
}
