package visitor.husivm;

class VoiceVisitor implements Visitor {
    @Override
    public void voiceDog() {
        System.out.println("woof");
    }

    @Override
    public void voiceCat() {
        System.out.println("meow");

    }
}
