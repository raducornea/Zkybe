using IdentityServer_UAC.Data.Interfaces;
using IdentityServer4.Extensions;
using IdentityServer4.Models;
using IdentityServer4.Services;
using System.Security.Claims;

namespace IdentityServer_UAC.Configurations
{
    public class ProfileService : IProfileService
    {
        private const string USER_ROLE = "user";
        private const string ADMIN_ROLE = "admin";

        private readonly IUserRepository _userRepository;

        public ProfileService(IUserRepository userRepository)
        {
            _userRepository = userRepository;
        }

        public async Task GetProfileDataAsync(ProfileDataRequestContext context)
        {
            var sub = context.Subject.GetSubjectId();
            var user = await _userRepository.GetUserAsync(int.Parse(sub));
            if (user == null)
                return;

            var claims = new List<Claim>
            {
                // TODO: add roles to user !!!
                //new Claim("role", user.Role == 1 ? ADMIN_ROLE : USER_ROLE),
                new Claim("role", USER_ROLE),
                new Claim("username", user.Nickname)
            };

            context.IssuedClaims.AddRange(claims);
        }

        public async Task IsActiveAsync(IsActiveContext context)
        {
            var sub = context.Subject.GetSubjectId();
            var user = await _userRepository.GetUserAsync(int.Parse(sub));
            context.IsActive = user != null;
        }
    }
}
