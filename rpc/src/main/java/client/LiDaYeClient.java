package client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import server.MsgDecoder;
import server.MsgEncoder;
import server.PackageDecoder;

/**
 * @author chenjiapan3
 * @date 2023/6/6
 */
public class LiDaYeClient {

    public void start(){
        /**
         * NioEventLoopGroup对象用于处理客户端连接的I/O事件和执行任务
         * 对于客户端连接，通常使用单线程模式，因为客户端连接相对较少，可以避免线程上下文切换和锁竞争的问题
         */
        NioEventLoopGroup group = new NioEventLoopGroup(1);

        // Bootstrap对象用于创建客户端的类，配置客户端的参数
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                // 指定线程模型
                .group(group)
                // 指定I/O类型为NIO
                .channel(NioSocketChannel.class)
                // I/O处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // addLast方法用于向channelPipeline中添加channelHandler
                        socketChannel.pipeline().addLast(new PackageDecoder());
                        socketChannel.pipeline().addLast(new MsgDecoder());
                        socketChannel.pipeline().addLast(MsgEncoder.INSTANCE);
                    }
                });

    }

}
