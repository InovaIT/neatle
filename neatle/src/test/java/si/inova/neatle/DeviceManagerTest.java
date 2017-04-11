/*
 * MIT License
 *
 * Copyright (c) 2017 Inova IT
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package si.inova.neatle;

import android.bluetooth.BluetoothDevice;
import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import si.inova.neatle.util.DeviceManager;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.N_MR1)
public class DeviceManagerTest {

    private DeviceManager deviceManager;

    @Before
    public void setUp() {
        deviceManager = DeviceManager.getInstance(RuntimeEnvironment.application);
    }

    @Test
    public void instanceTest() {
        assertNotNull(DeviceManager.getInstance(RuntimeEnvironment.application));
    }

    @Test
    public void getDeviceTest() {
        BluetoothDevice bluetoothDevice = Mockito.mock(BluetoothDevice.class);
        Mockito.when(bluetoothDevice.getAddress()).thenReturn("00:11:22:33:44:55");

        assertNotNull(deviceManager.getDevice(bluetoothDevice));
        assertNotNull(deviceManager.getDevice(bluetoothDevice));
    }
}
