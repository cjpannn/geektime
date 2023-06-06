package server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author chenjiapan3
 * @date 2023/6/6
 */
public class PackageDecoder extends ByteToMessageDecoder {

    private static LengthDecoder lengthDecoder = new LengthDecoder();
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        int lens = in.readableBytes();
        if (lens <= LengthDecoder.LENGTH_FIELD_LENGTH){
            return;
        }
        
        Object decode = lengthDecoder.decode(channelHandlerContext, in);
        if (decode != null){
            out.add(decode);
        }
    }
}
