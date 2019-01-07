package peep.biotic.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import peep.biotic.furnace.ContainerFastFurnace;
import peep.biotic.furnace.GuiFastFurnace;
import peep.biotic.furnace.TileFastFurnace;

import javax.annotation.Nullable;


//Guis both have a client side and a server side.
//The server side is the container e.g. ContainerFastFurnace
//This serves as a bridge between client side and server side.
public class GuiHandler implements IGuiHandler {

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileFastFurnace) {
            return new ContainerFastFurnace(player.inventory, (TileFastFurnace) te);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileFastFurnace) {
            TileFastFurnace containerTileEntity = (TileFastFurnace) te;
            return new GuiFastFurnace(containerTileEntity, new ContainerFastFurnace(player.inventory, containerTileEntity));
        }
        return null;
    }
}
