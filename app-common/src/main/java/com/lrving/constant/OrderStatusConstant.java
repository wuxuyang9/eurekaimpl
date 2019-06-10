package com.lrving.constant;

/**
 * Created by wangBaiChuan 2019-01-18.
 * 订单状态。
 */
public interface OrderStatusConstant
{

    /**
     *  签收：退货
     *  拒签：原路返回
     *
     *   参考：
     *   购买状态：100(进行中)->200(待发货)->300(待收货)->301(已收货)->900(已完成)
     *   退货状态（已发货/已收货）：
     *      300(已发货=待收货)/301(已收货)->400(退货中)->401(待退款)->402(已退款=等待用户确认退货退款)>904(退货退款已完成)
     *   取消订单（未付款）：100->999
     *   取消订单（已付款/待发货）：200->403->404->999
     */
    @ConstantName("待付款")
    short WAIT_PAY              = 100;

    @ConstantName("用户已付款，待后台接收微信回调")
    short WAIT_CONFIRM_PAY      = 101;

    @ConstantName("待发货")
    short WAIT_SHIP_SEND        = 200;

    @ConstantName("待收货")
    short WAIT_SHIP_TAKE        = 300;
    @ConstantName("已收货")// 第三方获取信息发现已签收，暂时不用。
    short WAIT_SHIP_TOOK        = 301;

    @ConstantName("用户退货退款申请")
    short REFUND_APPLY          = 400;
    @ConstantName("等待用户退货")
    short REFUND_SHIP_TAKE      = 401;
    @ConstantName("等待店铺退款")
    short REFUND_PAY            = 402;
    @ConstantName("等待用户确认退货退款")
    short REFUND_OK             = 403;

//    @ConstantName("取消订单的申请")
//    short CANCEL_APPLY          = 500;
//    @ConstantName("已付款/待发货的取消订单，等待店铺退款")
//    short CANCEL_PAY            = 501;
//    @ConstantName("已付款/待发货的取消订单，已退款")
//    short CANCEL_PAYED          = 502;
//    @ConstantName("已付款/待发货的取消订单，等待用户确认已取消")
//    short CANCEL_OK        = 405;//

    @ConstantName("已完成")
    short FINISHED              = 900;
    @ConstantName("删除")
    short DELETED               = 901;
    @ConstantName("取消")     // 代发货之前取消，直接退款。
    short CANCEL_FINISHED       = 902;
    @ConstantName("交易关闭")// 指定时间内没有支付。
    short CLOSED                = 903;
    @ConstantName("退货退款已完成")
    short REFUND_FINISHED       = 904;

}
