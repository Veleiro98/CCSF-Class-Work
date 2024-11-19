import numpy as np
import matplotlib.pyplot as plt
t = np.linspace(0, 40, 1000) # start, finish, n points
# distance travelled by robber d = 2.5t
d_4 = 2.5*t
# distance travelled by sherrif: d = 3(t-5)
d_s = 3 * (t-5)
fig, ax = plt.subplots()
plt.title('A Bank Robber Caught')
plt.xlabel('Time (Minutes)')
plt.ylabel('Distance (km)')
ax.set_xlim([0,40])
ax.set_ylim([0,100])
ax.plot(t, d_4, c='green')
ax.plot(t, d_s, c='brown')
plt.axvline(x=30, color ='purple' , linestyle='--')
_ = plt.axhline(y=75, color='purple', linestyle='--')
plt.show()