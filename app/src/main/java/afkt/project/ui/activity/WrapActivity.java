package afkt.project.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;

import afkt.project.R;
import afkt.project.base.app.BaseToolbarActivity;
import afkt.project.ui.widget.BaseTextView;
import butterknife.BindView;
import dev.temp.ChineseUtils;
import dev.utils.app.ShapeUtils;
import dev.utils.app.helper.ViewHelper;
import dev.utils.common.RandomUtils;
import dev.widget.WrapView;

/**
 * detail: 自动换行 View
 * @author Ttt
 */
public class WrapActivity extends BaseToolbarActivity {

    @BindView(R.id.vid_aw_wrapview)
    WrapView vid_aw_wrapview;

    @Override
    public int getLayoutId() {
        return R.layout.activity_wrap;
    }

    @Override
    public void initValues() {
        super.initValues();

        // 设置最大行数
        vid_aw_wrapview.setMaxLine(10);
//        // 设置每一行向上的边距 ( 行间隔 )
//        vid_aw_wrapview.setRowTopMargin(10);
//        // 设置每个 View 之间的 Left 边距
//        vid_aw_wrapview.setViewLeftMargin(20);
//        // 设置每一行第一个 View Left 边距
//        vid_aw_wrapview.setRowFristLeftMargin(30);
//        // 快捷设置三个边距
//        vid_aw_wrapview.setRowViewMargin(10, 20, 30);

        // 设置点击效果
        GradientDrawable drawable = ShapeUtils.newBuilder(30f, R.color.color_88).build().getDrawable();


        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < 100; i++) {
            // 随机字符串
            String text = ChineseUtils.getRandomWord(RandomUtils.getRandom(20)) + RandomUtils.getRandomLetters(RandomUtils.getRandom(10));
            String randomText = RandomUtils.getRandom(text.toCharArray(), text.length());

            BaseTextView baseTextView = new BaseTextView(this);
            ViewHelper.get().setLayoutParams(baseTextView, layoutParams)
                    .setPadding(baseTextView, 30,15, 30, 15)
                    .setBackground(baseTextView, drawable)
                    .setMaxLines(baseTextView, 1)
                    .setEllipsize(baseTextView, TextUtils.TruncateAt.END)
                    .setTextColor(baseTextView, Color.WHITE)
                    .setTextSizeBySp(baseTextView, RandomUtils.getRandom(13, 15))
                    .setBold(baseTextView, RandomUtils.nextBoolean())
                    .setText(baseTextView, randomText);
            vid_aw_wrapview.addView(baseTextView);
        }
    }
}