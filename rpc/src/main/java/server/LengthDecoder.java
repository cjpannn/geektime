package server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 长度解析器
 * 从数据流中读取指定长度的字节，将其转换为消息，并将消息发送到下一个 ChannelHandler 进行处理
 * @author chenjiapan3
 * @date 2023/6/6
 */
public class LengthDecoder extends LengthFieldBasedFrameDecoder {
    /** 消息的最大长度，如果超过该长度，则会触发 TooLongFrameException 异常 */
    public static final int MAX_FRAME_LENGTH = 32;

    /** 长度字段的偏移量，即长度字段在字节流中的起始位置 */
    public static final int LENGTH_FIELD_OFFSET = 0;

    /** 长度字段的长度，即长度字段所占用的字节数 */
    public static final int LENGTH_FIELD_LENGTH = 1;

    public LengthDecoder() {
        super(MAX_FRAME_LENGTH, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }
    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        return super.decode(ctx, in);
    }
}
