package endergeticexpansion.client.model.booflo;

import endergeticexpansion.api.endimator.EndimatorEntityModel;
import endergeticexpansion.api.endimator.EndimatorRendererModel;
import endergeticexpansion.common.entities.booflo.EntityBooflo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * BoofloDefault - Endergized
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelBoofloInflated<E extends EntityBooflo> extends EndimatorEntityModel<E> {
    public EndimatorRendererModel Head;
    public EndimatorRendererModel KneeLeft;
    public EndimatorRendererModel KneeRight;
    public EndimatorRendererModel LegLeft;
    public EndimatorRendererModel LegRight;
    public EndimatorRendererModel Jaw;
    public EndimatorRendererModel LegBackLeft;
    public EndimatorRendererModel LegBackRight;

    public ModelBoofloInflated() {
        this.textureWidth = 150;
        this.textureHeight = 150;
        this.LegRight = new EndimatorRendererModel(this, 28, 66);
        this.LegRight.setRotationPoint(-8.5F, 2.0F, -3.0F);
        this.LegRight.addBox(0.0F, -1.5F, -1.5F, 20, 3, 3, 0.0F);
        this.setRotateAngle(LegRight, 0.0F, 0.5235987755982988F, 3.141592653589794F);
        this.LegBackLeft = new EndimatorRendererModel(this, 0, 81);
        this.LegBackLeft.setRotationPoint(1.5F, -7.5F, -0.5F);
        this.LegBackLeft.addBox(0.0F, -1.5F, -1.5F, 25, 3, 3, 0.0F);
        this.setRotateAngle(LegBackLeft, 0.0F, -0.3490658503988659F, 0.3490658503988658F);
        this.Jaw = new EndimatorRendererModel(this, 0, 97);
        this.Jaw.setRotationPoint(0.0F, 4.0F, 8.0F);
        this.Jaw.addBox(-16.0F, 0.0F, -24.0F, 32, 16, 32, 0.0F);
        this.KneeRight = new EndimatorRendererModel(this, 0, 58);
        this.KneeRight.setRotationPoint(-5.5F, -2.0F, 5.5F);
        this.KneeRight.addBox(-2.5F, -10.0F, -2.5F, 5, 10, 5, 0.0F);
        this.setRotateAngle(KneeRight, 0.0F, 0.17453292519943295F, -0.5585053606381855F);
        this.LegLeft = new EndimatorRendererModel(this, 28, 59);
        this.LegLeft.setRotationPoint(8.5F, 2.0F, -3.0F);
        this.LegLeft.addBox(0.0F, -1.5F, -1.5F, 20, 3, 3, 0.0F);
        this.setRotateAngle(LegLeft, 0.0F, 0.5235987755982988F, -2.4802620430283604E-16F);
        this.Head = new EndimatorRendererModel(this, 0, 29);
        this.Head.setRotationPoint(0.0F, 3.9999999999999947F, 0.0F);
        this.Head.addBox(-9.0F, -4.0F, -9.0F, 18, 8, 18, 0.0F);
        this.setRotateAngle(Head, 3.1003275537854505E-17F, 0.0F, 0.0F);
        this.KneeLeft = new EndimatorRendererModel(this, 0, 58);
        this.KneeLeft.setRotationPoint(5.5F, -2.0F, 5.5F);
        this.KneeLeft.addBox(-2.5F, -10.0F, -2.5F, 5, 10, 5, 0.0F);
        this.setRotateAngle(KneeLeft, 0.0F, -0.17453292519943295F, 0.558505360638178F);
        this.LegBackRight = new EndimatorRendererModel(this, 0, 89);
        this.LegBackRight.setRotationPoint(-1.5F, -7.5F, 0.0F);
        this.LegBackRight.addBox(-25.0F, -1.5F, -1.5F, 25, 3, 3, 0.0F);
        this.setRotateAngle(LegBackRight, 0.0F, 0.3490658503988659F, -0.3490658503988659F);
        this.Head.addChild(this.LegRight);
        this.KneeLeft.addChild(this.LegBackLeft);
        this.Head.addChild(this.Jaw);
        this.Head.addChild(this.KneeRight);
        this.Head.addChild(this.LegLeft);
        this.Head.addChild(this.KneeLeft);
        this.KneeRight.addChild(this.LegBackRight);
    }

    @Override
    public void render(E booflo, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Head.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(EndimatorRendererModel EndimatorRendererModel, float x, float y, float z) {
        EndimatorRendererModel.rotateAngleX = x;
        EndimatorRendererModel.rotateAngleY = y;
        EndimatorRendererModel.rotateAngleZ = z;
    }
}