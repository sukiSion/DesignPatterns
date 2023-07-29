package com.example.designpatternsapp.mediatormodel.cd

abstract class Mediator{
    abstract fun change(colleague: Colleague)
}

class MainBoard(
) : Mediator(){
    var cpu: CPU = CPU(this)
        set(value) {
            field = value
        }
    var cdDevice: CDDevice = CDDevice(this)
        set(value) {
            field = value
        }
    var graphiceCard: GraphiceCard = GraphiceCard(this)
        set(value) {
            field = value
        }
    var soundCard: SoundCard = SoundCard(this)
        set(value) {
            field = value
        }



    override fun change(colleague: Colleague) {
        if(colleague is CPU){
            graphiceCard.videoPlay(cpu.dataVideo)
            soundCard.soundPlay(cpu.dataSound)
        }else if(colleague is CDDevice){
            cpu.decodeData(colleague.getData())
        }
    }

}
