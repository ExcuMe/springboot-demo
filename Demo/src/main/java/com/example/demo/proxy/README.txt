静态代理在编译时产生class字节码文件，可以直接使用，效率高。
动态代理必须实现InvocationHandler接口，
通过invoke调用被委托类接口方法是通过反射方式，
比较消耗系统性能，但可以减少代理类的数量，使用更灵活。
cglib代理无需实现接口，通过生成类字节码实现代理，比反射稍快，不存在性能问题，
但cglib会继承目标对象，需要重写方法，所以目标对象不能为final类。