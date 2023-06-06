package server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import msg.Message;

/**
 * @author chenjiapan3
 * @date 2023/6/6
 */

@ChannelHandler.Sharable
public class MsgEncoder extends MessageToByteEncoder<Message> {
    public static final MsgEncoder INSTANCE = new MsgEncoder();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        if (message == null){
            throw new RuntimeException("encode message null");
        }

        byte[] bytes = message.getMsg().getBytes();
        int len = bytes.length;
        byteBuf.writeByte(len);
        byteBuf.writeBytes(bytes);
    }
}
