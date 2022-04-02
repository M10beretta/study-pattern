package visitor.husivm;

class Dog implements Animal {
    @Override
    public void voice(Visitor v) {
        v.voiceDog();
    }
}
