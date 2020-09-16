package com.ycit.example.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author chenxiaolei
 * @date 2020/9/1
 */
public class DiscardServer {

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    /**
     * NioEventLoopGroup 是一个多线程事件循环处理的I/O操作。Netty提供了各种各样的EventLoopGroup
     * 来实现不同类型的传输。
     * 在这里我们实现了服务器方面的应用，因此将会使用两个EventLoopGroup。
     * 第一个，我们称作为'boss'，接收进来的连接
     * 第二个，我们称作为'worker,'一旦boss接受了这个连接并把该连接注册到了worker之后，就处理接受到的传输连接。
     * 有多个线程被使用，并且它们怎样映射到创建的Channels，
     * 依赖于EventLoopGroup的实现，并且可以通过构造来对它进行配置
     *
     * ServerBootstrap 是建立服务器的一个帮助类。
     * 我们可以使用Channel直接的设置这个服务器。
     * 然后，请注意这是一个枯燥的过程，并且在大多数情况下你不需要这么做。
     *
     * 这里我们指定使用NioServerSocketChannel
     * 类去实例化一个新的Channel，来接收进来的连接。
     *
     * 这里指定的处理者总是评估新接受的Channel。ChannelInitializer
     * 是一个指定的处理者，去帮助用户配置一个新的Channel。
     * 这是最有可能的，我们想要去配置ChannelPipeline关于新的Channel，
     * 通过添加处理者，列如DiscardServerHandler 来实现我们的网络应用程序。
     * 当应用程序变得复杂的时候，很有可能我们将添加更多的管道处理器，
     * 最终这个匿名类(ChannelInitializer)会被提取成为一个顶级类.
     *
     * 我们也可以在Channel 实现的时候指定一些参数。
     * 当前我们正在写一个TCP/IP服务器，因此我们可以设置一些socket的可选参数。
     * 列如tcpNoDelay和keepAlive。
     *
     * @throws Exception
     */
    public void run()throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[]args)throws Exception {
        int port = 8080;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        new DiscardServer(port).run();
    }

}
