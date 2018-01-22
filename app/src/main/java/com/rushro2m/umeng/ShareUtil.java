package com.rushro2m.umeng;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/**
 * Created by 16918 on 2018/1/22.
 */

public class ShareUtil {

    static final SHARE_MEDIA[] displaylist = new SHARE_MEDIA[] { SHARE_MEDIA.WEIXIN,
            SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ,
            SHARE_MEDIA.SINA };

    /**
     * 固定QQ分享
     */

    public static void showShareQQ(final Context context, String title,
                                   String content, String url, String imageUrl) {
        UMImage image = new UMImage(context, imageUrl);
        new ShareAction((Activity) context)
                .setDisplayList(SHARE_MEDIA.QQ)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        Toast.makeText(context, "开始分享", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                        Toast.makeText(context, "开始成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                        Toast.makeText(context, "分享错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {
                        Toast.makeText(context, "分享取消", Toast.LENGTH_SHORT).show();
                    }
                })
                .withMedia(image)
                .withText(content)

                .share();
    }
}
