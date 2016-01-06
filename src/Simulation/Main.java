package Simulation;

import java.io.*;

public class Main
{
    /**
     * This is the main function which triggers simulations
     * @param args
     */
    public static void main(String[] args)
    {
        double mutationRate = 0.3;
        double crossOverRate = 0.1;
        double mutationAmount = 0.1;
        boolean verbose = false;
        double globalScale = 0.1;
        double localScale = 0.2;
        double randomScale = 0.3;

        double[][] psoWeights = {
                {
                        -2.1827712928375355E22, -2.714187787861116E22, -1.207086283308601E21, -4.790309190646043E22, -1.189212048641437E22, 4.577805222615349E22, 2.7575394348305524E22, -2.995882939051523E21, -4.878666615818758E22, -1.6553875273622435E22, 1.7282773086762856E22, -2.706649202191671E22, 7.574693533357408E22, -5.302825499703793E22, -4.465951549828271E22, 1.6485049836608292E22, 3.568554825005976E22, 1.571022971802199E22, -3.86952217223574E22, -1.2712761093817746E21, 5.726083082778657E22, -3.6223064756128087E22, 1.5030561734869285E22, 2.2916281308768945E21, 4.002685657069959E22, -1.1323748033029504E22, -1.1411974995959494E22, 1.258110443586057E22, -8.706537956421874E20, 9.878372655387E21, 1.0034972432466042E22, 3.2002172046935996E22, -3.2682875190229795E22, -2.765921220466826E22, 1.1572051795992316E22, -1.248815236666122E22, 3.935724118301547E22, 3.8281542295094E22, -2.7813594683854733E22, 5.2396356970419705E22, -4.799308029295299E22, 4.380378753255938E22, 3.950618743101621E22, -5.769852113311448E21, 2.0145844620345844E22, -3.5061381611368628E22, 3.02878725641617E22, -2.3047836285817718E22, -9.757064723112294E21, 2.3910050943393625E22, 1.3476996480888694E22, 2.727167374823269E22, 3.2779734841076123E22, -4.504455037291222E22, 5.284007624796552E22, -5.181137408291421E22, 1.0554544843725503E22, 1.1886867781305244E22, -1.7548340609186924E22, 9.394552981321278E21, -6.204198583138991E22, -6.222818923334049E22, -5.393342407031911E22, 5.266606885258269E22, 4.79558639629185E22, -1.9492501020000748E22, 3.1282169051968034E22, -4.3806463400741844E22, -5.441701111139432E22, -1.241752992021045E21, -3.339184970776361E22, 8.974828659143569E21, 3.531370114348279E22, -3.3137113188776358E22, -6.234729279516411E22, -2.149669349949392E22, 3.4660715236376596E22, 4.0470286506113244E22, -3.785755235101155E22, -2.819794587102644E22, 5.278541177222249E22, -2.5721144775538387E22, 2.2037893112343424E22, -1.6646917425395164E22, 4.793166995280244E22, -5.228751599492334E22, -5.914917981315366E22, 3.862400142016055E22, -1.961260669847712E22, -6.336890959381438E22, -5.375572829819432E21, 4.437430524022195E22, 4.413295799219516E22, -6.275570966454809E21, 3.3929836660783093E22, -1.1215519935757766E22, -1.5786115209256262E22, 5.961312018875625E22, 1.4930528260997492E22, 5.870239218761649E22, 3.0268745951703116E22, 6.178075568787418E20, 2.407744251553906E22, 2.1543957001824476E22, -1.8715732014401073E22, -7.524354162422337E20, 5.2590245668675205E22, 3.3235847011748284E22, 1.7285821831610236E22, 1.7398648116587147E22, 4.349555787786289E22, -4.359817195087774E22, -6.765731574824099E22, -2.681408366982542E22, -3.5799154983626986E22, -9.72015614134916E21, -4.369554069234374E21, 1.1834080587642883E21, -3.902177132565063E22, -4.790287746892177E22, -1.0536274431723595E22, -3.378975333879484E22, 9.709289492217363E21, 1.4820428266348132E22, -3.446498578148536E21, -3.4718247489424685E22, -2.913237167137639E21, 2.5187083629853057E22, -1.6200577040746612E22, 4.155486929425266E22, 8.205512713632733E21,
                }
        };

        double[][] gaWeights = {
                {
                        -0.14899130238668445, -0.4033448622361778, 0.6051573027202453, -0.07413055152118929, 0.0018654359405870097, -0.8496074011041458, -0.13531742731914131, -0.3369946562054821, 0.5192214928102127, 0.651068177724536, 0.06408670512439246, -0.7044506601332778, -0.06583553581938639, -0.34299217075316324, 0.3352841990024502, 0.5125063113476703, -0.7442801096060887, -0.6130851000132861, 0.752742996086484, -0.527173228549243, 0.6498201217304078, -0.21314504039859736, -0.6675992230370744, 0.5052470195382048, 0.585281364067552, 0.7420430053271819, 0.10826125482518023, -0.21584574126429984, 0.8233480370122103, 0.12007242356068137, 0.30538622924593084, -1.0021765671306617, 0.2984602859206176, 0.31517293025931803, -0.8307660179805139, 0.9350648974541796, 0.1870012477443704, 0.3033897173245049, 0.1834208135300018, -0.548919680707056, 0.9145222495528619, 0.2735602332296285, 0.4447728045997126, 0.9488799726623072, -0.13016447335507514, 0.09808506716680157, -0.1939287094561461, 0.06666039532863077, -0.41576178607384423, -0.3687758776873207, 0.2819182887613645, -0.3451673910088836, 0.6933797760851628, -0.4031923329456956, -0.05478699321092284, -0.4145010119308417, -0.9828776501816683, 0.07386891204109577, -0.9936636972912765, 0.0611412100128533, -0.07215920613534635, 0.8885280279711405, -0.8890883643222336, 0.07290677799640721, -0.3149672093431699, -0.049954889006532666, -0.6859030417069691, -0.5896612037940622, 0.4345162536316125, -0.01724553363900516, 0.6273530657361562, -0.9039555002808652, -0.02237889100012419, -0.6711704520435092, 0.44308460946782235, -0.1369562479333804, 0.7626174112717521, -0.5268151751013364, -0.2808611495201373, -0.23211553066137236, -0.8533116803262257, -0.03557430669564947, 0.7320400542223828, 0.8192342019680752, -0.2695117128455241, 0.40454928349611896, -0.8468202418727436, -0.6695197472755742, -0.38630923572500797, -0.8689582176270869, -0.09010543710245741, 0.5494127682858256, 0.3432881458827238, 0.4326085162562552, 0.7197683937094657, 0.5333194850924949, -0.6683593710414124, -0.24719133170631827, 0.7812083971719967, -0.09214139984833022, -0.32282776340738084, 0.1690994767079762, -0.793550323526282, -0.32860465010508544, -0.14179102828378579, -0.7931676373892935, 0.3286871754839715, 0.350802380563791, 0.29227847449277744, 0.7354613017963485, -0.09035524040218793, 0.007117454868680789, -0.9119611160452292, 0.3831058778990694, -0.7163954602656356, -0.6274071099983572, 0.6146455201088308, -0.515473894767747, -0.12658526814528948, 0.5019848713542203, 0.04548674256977736, -0.1958165085801744, 0.174293504692725, -0.18069292715048854, -0.28383038145540446, -0.3007342569467714, -0.511992481240672, 0.19152402873641194, -1.0390311703989001, 0.2838942885170402, 0.4853810308422238,
                },
                {
                        0.06705439956942616, 0.9505050367863057, -0.9673845097588845, -0.7638398426315669, 0.8571015504897628, 0.29897449099188605, -0.5349792611732621, 0.7438378024892298, 0.5299643392055888, 0.8200526619297763, -0.4062431903585806, 0.7568509903586742, -0.5254122711684761, -0.918570528516315, -0.6807392328849866, -0.8663228977735615, 0.9600526670732834, -0.7745641281050111, 0.9179615356601101, 0.5902445255639459, 0.24835376621610133, -0.5839301602543723, 0.6372133315718362, -0.9981721664027263, 0.9194714943391092, 0.42262078467677155, -0.34983438910895637, -0.9694807309917155, -0.8251326713020877, -0.8078738425653023, -0.03807595423337928, 0.45631297675175947, 0.23829953536938708, 0.6593801671165709, -0.21277402645187382, -0.1338596961846846, 1.0061780010602088, 0.26740737612352644, -0.39132542786761615, 0.5501462155731655, -0.1562525156405672, -0.741207600434571, -0.20159428862561235, 0.5753564094550381, -0.4663148622072957, -0.4256589788832932, -0.5153895109043316, 0.07117558513090372, 0.2980691053033047, 0.6001030113380168, -0.3546045065447565, 0.5837903664884427, 0.0387414562206565, 0.17054626351761937, 0.015980434755316297, 0.536704751799947, -0.30161352246282247, 0.7960610335386653, -0.16531633217200903, -0.029984151000939374, -0.3003352554519694, -0.6620456222270701, -0.20505486996424782, -0.23751441726162592, 0.01395051759770527, 0.08904220159054788, -0.864912430758219, 0.3433579032760131, 0.9521836897650369, -0.7349297899456644, 0.6510339301909098, -0.9683409802287293, 0.08783584641335263, -0.9157278113574381, 0.09325814183804026, 0.5912489414344435, -0.13116997453128157, 0.47747614231586505, -0.29220399823556487, -0.8909669894855701, 0.12768857125698818, 0.16166218112757336, -0.08470377004266819, -0.8368426199065155, -0.9521234739673845, 0.011319272356531407, -0.9991817627770954, -0.1729837349661647, -0.7503432251125344, 0.5461688386162633, -0.6999836093758502, 0.5512772113255471, -0.7146122744794927, -0.8798699675930481, -0.5245311921566185, 0.5728597342631667, 0.06454339814215215, 0.48442761171319615, 0.49849915319030047, 0.5868706273765927, -0.6725717253307293, -0.781266237990778, 0.18495800288516162, 0.5619263134486414, -0.6118951428718988, -0.2036784517499146, -0.0036362181914944003, -0.560740242073066, 0.4210093162152577, -0.9988813576461872, 0.0715293427094903, 0.25531522201164925, 0.5833076320296511, 0.8597555948191589, -0.8120453740728695, 0.11573699365634482, -0.7532385708985904, -0.4173581481509947, 0.21359259005478748, -0.685942666136402, -0.45764480878988456, -0.490357866003611, 0.5567603675171995, 0.6019888183344306, 0.9189318439347844, -0.689802965396789, 0.8651628093071643, -0.17909567463876686, 0.8162981283752786, -0.32716472695492516, -0.7114204146430358,
                },
                {
                        -0.6253079071675958, -0.9182857965063618, -0.14464349857425451, 0.9634535911846005, 0.5992582711477072, 0.6183244985225939, 0.3383848459100861, 0.7692973797548066, -0.5965649986008128, -0.7277430925294328, 0.5036142012046076, -0.5096035523677352, 0.6978397919300137, -0.8232790934528293, 1.0526600314043126, 0.5321179813472963, 0.5001620072612213, -0.203711499447159, 1.023116240870051, -0.5327179632232456, -0.5053741615319209, 0.6324355788381308, 0.6391675680445514, 0.5123052662249201, 0.7634795396465158, -0.4155203310701751, -0.3727322997579621, -0.4739398780548245, 0.08080511932719106, -0.2606647979740082, 0.9748309247487646, 0.12236294155723804, -0.4831473542892565, 0.9694914434236015, 0.9340920512738342, -0.6187873340582783, -0.034082741393069105, 0.8739718111041179, -0.6203736397367949, -0.4095510742837747, -0.7345524373679995, -0.3605048093390148, -0.6781732712384638, -0.8302675617878953, 0.21789303801698212, 0.39174938506256324, 0.15952602582549424, -0.3070627659715308, -0.5798006982376019, -0.2222893343770952, 0.1234189659278766, 0.540088426214631, 0.3472956568869624, 0.020971858462637827, 0.6695912848184474, 0.7611599622194252, -0.2898886564212674, 0.010367858750890552, 0.15552586474341923, -0.3215951306505188, -0.8426621648096022, -0.8395285887122454, 1.010781384510796, 0.8865309906985521, -0.7358737463147976, -0.9555282759213535, 0.27143030026702747, 0.8856893087850881, 0.31039013688971817, 0.1124716397640595, 0.5543295805922249, 0.0814296121846112, -0.26202038579478404, 1.0654536678483437, -0.6216896689881461, -0.8314806503461782, 0.4461784515639631, -0.8544616284218443, -0.18598925294181767, -0.7660982148509072, 0.1143432468253347, -0.832746953657598, 0.024249159756727146, -0.4565163426790133, 0.8241264517564908, -0.04378355457165517, -0.22612449454850236, 0.5643899175476856, -1.044528433870869, 0.7427509862807309, 0.09159402714791046, 0.6272919581341777, -0.5569544595551454, 0.9171908495857848, 0.3718831014598747, 0.4009790084616383, 0.3805787292514311, 0.5752474477179559, 0.7810951110930248, -0.13416958950419716, 0.14110699322026332, -0.8967043286887474, 0.2449105484438443, -0.4916541522766269, 0.9805036159261034, -0.5000586764807852, -0.04766949875485103, -0.01036615100347077, -0.049486759628242005, -0.49146728138608364, 0.8429818643618319, -0.8565414004515284, 0.43439194280574367, 0.5322991634191572, -0.657744544715354, 0.5049449030758604, 0.9610122810643085, -0.4532634083928728, -0.534833777388503, -0.03644845115528372, -0.8124234981338629, -0.09072573850078425, 0.8153217989314969, -0.010528636475872988, 0.7491077486860708, 0.3319387297350417, 0.7851948533131309, 0.7942234667962119, 0.11556484989602978, 0.6252139304956468, 0.8820524979795001,
                },
                {
                        0.7885586193463039, 0.9650104551681393, 0.964952532225547, 0.6821831819203334, 0.47706976527671774, 0.5947380447294031, 0.5277543390085013, 0.43861007319519896, -0.6642934591489422, 0.1326729836863998, -0.7442022975645963, 0.3781646315876336, -0.5333241813700251, 0.8647412353895324, -0.34189316207234954, 0.3483950240088781, -0.6985790287638769, 0.462821348952301, 0.2944465285075466, 0.8429360537883355, -0.5773118280918452, -0.14975564615341663, 0.26314547766488783, -0.11002631512752635, -0.5393600447218454, -0.912247837243801, -0.6090717414605592, 0.2914391318401701, 0.847973161047768, 0.949016126507626, -0.7128457442620055, 0.9227787397966704, -0.6762616548573614, -0.8564920706667423, -0.5755545001543878, -0.7313080412690387, -0.5051287976300489, 0.21005381253354427, -0.7187201250789408, 0.6071172736162738, 0.9206723730531321, -0.7521469332105186, -0.612619127084116, -0.3675145985026773, -0.9514597500647137, 0.8149103913597088, -0.5488904867940687, 0.10253415588779036, -0.20204334193861181, 0.7923363832317543, -0.43249316982713437, -0.898010860299729, 0.5098857583848766, 0.891529281289327, 0.8473070255601407, 0.6324546727406797, -0.1011587810360901, -0.09538913619646869, 0.3112507650272913, 0.7734707832945713, 0.9884469267457757, -0.7437429968226086, -0.9873896157247877, -0.2588395289641694, -0.020580156089291313, -0.15288130306421888, -0.2038336117729287, -0.9471640194808999, -0.377526296151959, 0.06597011301495193, -0.20063846747783542, -0.995332914079027, -0.5453901942844606, 0.9228741408107914, -0.5298538603779281, 0.47240444178011454, -0.42775168102840083, 0.6549512984885787, 0.5174924630940462, -1.0885562218659743, 0.6491951288319631, -0.7885961932242791, 0.1817605668212683, -0.9482087242747252, -0.6847838598115392, -0.07995018731457451, -0.3940026772661871, -0.3164732017739282, 0.037809290305967885, 0.8847398548413135, -0.13066639964620924, 0.6248494887459153, 0.5277180673182322, 0.9734039473741911, 0.6550531567003497, -0.039781363498262154, -0.6330076988171927, 0.8339500842735708, -0.7146688997142443, -0.17538176160522068, 0.2078833421694262, 0.8662788868612493, 0.8973585520397909, 0.8025377552792198, 0.02978814200762936, 0.49300386183251854, 0.2396138896610427, -0.9188308431693211, 0.20962027211264478, 0.15270704582149053, -0.3548007678921532, 0.569709736321748, 0.10993362054070888, 0.07828022896959794, 0.6750817810632286, -0.9669277298958876, 0.47593560477161434, 0.1943351509411212, 0.06652075589489295, -0.4959415464492263, 0.1829343308264902, 0.2969739156355652, -0.28469242734060596, -0.20696206248493557, -0.9136693419226782, 0.9855302598558144, 0.8724175337070552, 0.6167995195719289, 0.4105157855754519, 0.8477241215214719, -0.3370986043624793,
                },
                {
                        -0.225931489583783, 0.21227296469238227, 0.2030063273279162, -1.0740684069728381, 0.6559730127727292, -0.1632279229447955, -0.7299875765678374, 0.159229579036116, 0.9028764826773998, -0.5492780426088824, 0.8507103976698919, -0.06414219097256224, -0.6551852778598447, 0.08650003991012967, -0.2333842474102244, -0.07756422352354941, -0.9471457315115609, -0.22606693034273628, 0.19870298121430907, -0.5747567885280371, 0.28112200143914, -0.4549237163673667, 0.7429471504990812, -0.49103581325148593, -0.9644123813779727, -0.1595309052741564, -0.10207121197438221, 0.032928324712673485, 0.8961362657933387, 0.7598964528710215, -0.5733013463645705, 0.7964022955257284, -0.49766457640449313, 0.8645180515091535, -0.7195663662442073, 0.06534116245161203, 0.49123428572362404, -0.0756425309269752, 0.16775701241150404, 0.4782137461698337, -0.535694499232976, 0.6893437419860379, 0.9924446576743885, -0.7814009783713085, 0.844212403983277, 0.2075392327243531, -0.18243143824026742, 0.03260365723695924, -0.37738871286127873, 0.05684730409182048, 0.22114768547658725, 0.731296540271636, 0.29873760618680545, -0.1461564329809979, -0.5609638954291081, 0.4354611677129452, -0.035850810163212066, -0.7340916127792707, -0.9974849708939466, 0.5708105579742735, -0.7852875374274353, 0.2965580100983529, 0.7942928878403477, 0.801818757917846, 0.7361047529195064, -0.7366230743497286, -0.8848960235778784, -0.5949835715102388, 0.984630394356355, 0.7163821142659998, 0.7870394612402632, 0.07143137266503019, -0.8440142024386835, -0.08804066231956442, -0.8611700959814034, 0.8138473857669721, 0.08328337837453659, -0.5511861040865969, -0.7341422322121622, 0.1598269555514871, -0.8674515972966175, 0.7707511894486205, 0.26743832996617956, -0.7287771327353398, -0.5889695410491098, 0.589169008636395, 0.14531818513205708, 0.8935583871632903, -0.9221672572512152, -0.5002357215904341, -0.5900819739334393, 0.2343216094482785, -0.5826182267294187, 0.7395147344796651, -0.10767155828739128, -0.9491976326114817, 0.05475449586405423, 0.13439445795163585, 0.28260347907315286, -0.12951685801462154, -0.06831891100087334, 0.3202573603742156, -0.2978560144780882, 0.08536018441046944, -0.38625672989566406, -0.529261469806557, 0.6271266837523592, 0.20194198516258255, 0.1214016015469519, -0.44995596417794725, -0.018112439425886917, -0.9170650339644382, -0.6834097616758972, -0.10658387528306124, 0.28562146985930803, -0.712985209710769, 0.14830572097123795, 0.6016941465665474, -0.5655881729530883, 0.4215557536354946, -0.545499451947106, -0.47129149963111194, -0.6835363047874619, -0.3864480300252444, 0.35007468427960053, 0.3849230221052389, -0.7820528394764172, 0.5634785262880677, 0.21915704676448908, -0.8941720865543943, -0.7238514426457756,
                },
                {
                        -0.6463701998803624, -0.2342639539905471, -0.047598399010294834, -0.12160835045070995, -0.4583072732255298, -0.1979384009552536, 0.7989253257859094, 0.16433044756689497, 0.6176809970238681, -0.6226329511587102, -0.5475631411784964, -0.21186448001586156, -0.618711071797164, 0.5343919253213729, -0.8099272053183553, -0.6383242956320958, 0.8846848342119036, -0.49127261610548945, -0.17710316711699242, -0.9794225889911048, 0.02207782518275865, -0.047853326363193505, -0.9502646038169218, 0.5624711200902635, -0.28581459391969455, 0.15302837256258028, 0.6056075183927438, 0.5720051352311601, 0.5892343425557778, -0.42998579273074294, -0.7236160826553824, -0.48350499440451467, 0.14340360868462132, -0.12387872159609059, -0.9425015529737097, -0.5856001646941198, 0.1624058678468001, 0.043598325151893005, -0.1877580235268126, -0.45920084871110745, -0.31930675781029194, 0.5428616178789536, 0.47498309218863977, -0.8955804142845689, -0.3670985751894804, 0.06833226365737266, -0.2088937728429583, 0.533939797475508, -0.014615584839468322, -0.9503950724485317, 0.2975832358452757, -0.8028433395741941, -0.0814465658593686, -0.4597721116085396, 0.6311169998493272, 0.8383664324387095, 0.3637491920207503, -0.5472866323084522, -0.03212077050820206, -0.41399177576217383, -0.793045939957727, -0.186225720571364, -0.03963445812244526, 0.008598902325845148, -0.5268636094398347, 0.42320348487884174, -0.33025290225173287, 0.0027188409230855803, 0.9385960513767979, 0.2438010937267735, -0.825827951542931, -0.07894904177754514, 0.6860578762258638, -0.21838538337411154, 0.8893726755543964, -0.7407803783088479, 0.5791983499427971, 0.9393774483005772, 0.6650733648742269, 0.15119300458735108, -0.7030974664150138, -0.890799564078641, -0.4419608763793128, 0.6157447986494509, -0.24847138928977586, -0.7766473606990532, -0.3328555675941882, 0.02165700581572394, -0.9085613222996953, 0.2463768479725652, -0.2190536160390033, 0.32702911221909714, 0.7970352929145341, -0.7702959550119473, 0.10104840942584964, -0.2262909327440099, 0.3373571646237079, -0.4856293068145807, -0.8342008606689064, 0.8149766185130478, -0.6623978626200537, 0.5547257615155705, -0.20769513457386202, 0.6253277922033396, 0.013009414782957585, -0.41025033991586746, 0.12805149784596281, -0.432681513638638, 0.9077366309962982, -0.8750625324023347, 0.9387353692426217, -0.3733142025817417, 0.8230694977949011, 0.9865257092828728, 0.5668915010328803, 0.3716833181610696, 0.1578192895926761, -0.42882892009076, -0.3380268215178781, -0.5997295541867125, 0.4119607272162842, -0.16198296901200693, 0.48958155251665225, 0.9627955830416377, 0.17605988889086532, -0.34065187433191324, 0.6987751455051348, 0.853916126751991, 0.010998157005021936, 0.531371606600183, -0.9065436944389982,
                },
                {
                        0.8071219067010862, 0.8002247874068511, 0.01696341460706119, 0.677024402136454, -0.8621493992571189, 0.7000272819197932, -0.8793822677467631, -0.1268004503630391, -0.029629687218213796, 0.27510075976928716, -0.9914446531399037, -0.3142177354040394, 0.7437276136143975, 0.06345083965521892, 0.9685671897338708, 0.9214383063799323, -0.0972696192187551, 0.4783584240366449, 0.7102564281119027, 0.025676381614243127, 1.0560441043681603, 0.7356222524053047, -0.6984274141285023, -0.7816406659738987, -0.874346729012778, -0.49334905476789814, 0.7311209605750921, 0.6139276899296846, 0.3410048129863186, 0.08371114462693258, 0.9242023081618704, -0.16241853013075125, 0.0992246158618339, -0.4912176112578678, -0.8546299465029563, -0.5472559336883591, 0.249662495600379, 0.9177875472221615, 0.07154353222648724, -0.2566908438499051, 0.49915634584169744, 0.04868803751276711, -0.15583416518831525, 0.6544509615807893, -0.5547623803952035, 0.6707918731127189, -0.10417034586725982, 0.4762601950779388, 0.07427360930616639, 0.7367446516522163, 0.2962495197964512, -0.03937435771448908, -0.6552754526360883, 0.8975804196191869, 0.7602477010012209, 0.3177026495047436, -0.5418933972203732, -0.3661694047775597, 0.97148824708042, 0.39301066018389275, -0.03571690356727007, 0.18631614605944244, 0.623628028724321, -0.5928813114697409, -0.7891123685812628, -0.9371869412057225, -0.7178645751029284, -0.8969626980857868, 0.8958691015050257, -0.8491716080957836, -0.4776594487609832, 0.08824771601349024, 0.37503430306686036, 0.602449457361073, 0.2590166027046761, 0.2527505341361507, 0.410511841339845, 0.2924374845246399, 0.46113977833544, 0.13033039465631546, 0.3840450995080578, 0.14878350828670506, -0.33191367566372776, 0.6250735410121666, 0.10103492371877068, 0.4018706917160175, -0.8022644691580503, 0.45845720744093793, 0.7873685789240492, 0.3025971226786581, -0.36018199692854247, 0.1418123044388151, 0.46581550374614245, 0.7246164450893744, 0.8148307695711656, 0.8590636828551932, 0.800642817455066, 0.1623777616245903, -0.15636821067927031, 0.7475886622437533, 0.6633964000974093, 0.5549050511866109, 0.6445452411023911, -0.98487264050243, 0.4930704127867936, -0.28989424018548454, 0.030060856325192675, 0.5916671905028692, -0.962936650954689, 0.07944122259467612, 0.47552448399143726, 0.01700642167114376, 0.048928501827592605, 0.8701305825535393, -0.6655197599982017, -0.2469971384196159, -0.017578426712725956, -0.46568399590295195, -0.8710151704423461, -0.8828198633690842, 0.8492008676628038, -0.9587363538071731, -0.010647927287259273, 0.7769421314990719, 0.17396920213124625, 0.04049643381206569, -0.9769182719388377, 0.38364265595224323, 0.6030958802547326, 0.13763120197472478, -0.7752065701655293,
                }
        };

//        runFightSimulation(gaWeights, gaWeights, 0, 0, true, 1);

        //runFightSimulation(inputs, inputs);

//        System.out.println("Basic vs. Advanced");
//        runFightSimulation(null, null, 1, 2, true, 2);
//        System.out.println("Advanced vs. Basic");
//        runFightSimulation(null, null, 2, 1, true, 2);

        long startTime = System.currentTimeMillis();



//        GA ga = new GA();
//        double[][] idealWeights = gaWeights; // ga.runGA(10, 1, mutationRate, crossOverRate, mutationAmount); //getIdealWeights(10, 1, mutationRate, crossOverRate, mutationAmount);
//
        PSO pso = new PSO(globalScale, localScale, randomScale);
        double[][] idealWeights2 = pso.getBestWeights(200, 10);

        System.out.println("PSO Weights:");

        for (int i = 0; i < idealWeights2.length; i++)
        {
            for (int j = 0; j < idealWeights2[i].length; j++)
            {
                System.out.print(idealWeights2[i][j] + ", ");
            }
            System.out.println();
        }
//
//        System.out.println("GA: ");
//        for (int i = 0; i < idealWeights.length; i++)
//        {
//            for (int j = 0; j < idealWeights[i].length; j++)
//            {
//                System.out.print(idealWeights[i][j] + ", ");
//            }
//            System.out.println();
//        }
//
//        verbose = true;
//
//        for (int i = 0; i < 2; i++)
//        {
//            System.out.println("GA is Red:");
//            runFightSimulation(idealWeights, idealWeights2, 0, 0, verbose, 1);
//            System.out.println("GA is blue");
//            runFightSimulation(idealWeights2, idealWeights, 0, 0, verbose, 1);
//            System.out.println("GA vs. basic");
//            runFightSimulation(idealWeights, idealWeights, 0, 1, verbose, 1);
//            System.out.println("basic vs. GA");
//            runFightSimulation(idealWeights, idealWeights, 1, 0, verbose, 1);
//            System.out.println("PSO vs. basic");
//            runFightSimulation(idealWeights2, idealWeights2, 0, 1, verbose, 1);
//            System.out.println("basic vs. PSO");
//            runFightSimulation(idealWeights2, idealWeights2, 1, 0, verbose, 1);
//        }
//
//        System.out.println("Run Time: " + (System.currentTimeMillis() - startTime));
    }

    /**
     * This method returns an array with the total fitness values of all units
     * for both teams in the form
     *
     * [
     *      Team 1: [
     *                  Soldiers: [
     *
     *                             ]
     *                   Tanks: [
     *
     *                              ]
     *                        etc...
     *              ]
     *
     *      Team 2: [
     *
     *              ]
     * ]
     *
     *
     * @param team1Inputs
     * @param team2Inputs
     * @return
     */
    public static double[][] runFightSimulation(double[][] team1Inputs, double[][] team2Inputs, int teamA, int teamB, boolean verbose, int round)
    {
        if (verbose)
        {
            System.out.println("Simulating a match");
        }

        Game game = new Game(team1Inputs, team2Inputs, verbose);

        // Battlecode2016_Simulation/src/Simulation
        String map = "/Users/fred/Desktop/battlecode-scaffold-master/Battlecode2016_Simulation/src/Simulation/maps/SoldierTest1.xml";


//        if (round % 4 == 1)
//        {
            map = "/Users/fred/Desktop/battlecode-scaffold-master/Battlecode2016_Simulation/src/Simulation/maps/SoldierGaurd1.xml";
//        }
//        else if (round % 4 == 2)
//        {
//            map = "FightMicroGA/Simulation/simulationMaps/frontlines.xml";
//        }
//        else if (round % 4 == 3)
//        {
//            map = "FightMicroGA/Simulation/simulationMaps/noeffort.xml";
//        }

        game.runMatch(map, teamA, teamB);

        double[][] results = new double[2][];

        results[0] = game.getTeamResults(0);
        results[1] = game.getTeamResults(1);

        return results;
    }
}