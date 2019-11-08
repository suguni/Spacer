package com.yuinb.app.spacer

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*


// https://developer.android.com/guide/topics/appwidgets

class SpacerWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        appWidgetIds.forEach {
            updateAppWidget(context, appWidgetManager, it)
        }
    }

    private fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val cal = Calendar.getInstance()
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.KOREA)
        val updateViews = RemoteViews(context.packageName, R.layout.spacer_widget_main)
        updateViews.setTextViewText(R.id.text, format.format(cal.time))
        appWidgetManager.updateAppWidget(appWidgetId, updateViews)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
    }

    override fun onEnabled(context: Context?) {
        super.onEnabled(context)
    }

    override fun onDisabled(context: Context?) {
        super.onDisabled(context)
    }

    override fun onDeleted(context: Context?, appWidgetIds: IntArray?) {
        super.onDeleted(context, appWidgetIds)
    }
}