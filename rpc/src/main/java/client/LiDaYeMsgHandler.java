package client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import msg.Message;

/**
 * @author chenjiapan3
 * @date 2023/6/6
 */
public class LiDaYeMsgHandler extends SimpleChannelInboundHandler<Message> {
    public static final LiDaYeMsgHandler INSTANCE = new LiDaYeMsgHandler();

    private final String z0 = "吃了没，您吶?";
    private final String l1 = "刚吃。";
    private final String l2 = "您这，嘛去？";
    private final String z3 = "嗨！吃饱了溜溜弯儿。";
    private final String l4 = "有空家里坐坐啊。";
    private final String z5 = "回头去给老太太请安！";

    //worker只有1个线程，不需要原子类
    private int cnt1 = 0;
    private int cnt2 = 0;
    private int cnt3 = 0;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message message) throws Exception {

    }
}
