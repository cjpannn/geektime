package server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import msg.Message;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 消息解析器
 * @author chenjiapan3
 * @date 2023/6/6
 */
public class MsgDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        // 读取字节并通过十六进制子面量0xff进行转换
        int len = byteBuf.readByte() & 0xff;

        byte [] data = new byte[len];
        byteBuf.readBytes(data);

        Message message = new Message(new String(data, StandardCharsets.UTF_8));
        list.add(message);
    }
}
